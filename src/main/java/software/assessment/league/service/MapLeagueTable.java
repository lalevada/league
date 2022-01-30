package software.assessment.league.service;

import software.assessment.league.domain.Points;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mark Andrews
 */
public class MapLeagueTable implements LeagueTable {

    Map<String, AtomicInteger> resultStore;

    public MapLeagueTable() {
        resultStore = new ConcurrentHashMap<>();
    }

    public void addPointsAward(final String team, final Points points) {

        if (resultStore.putIfAbsent(team, new AtomicInteger(points.getValue())) != null) {
            resultStore.get(team).getAndAdd(points.getValue());
        }
    }

    public void print(final PrintWriter writer) {

        AtomicInteger rank = new AtomicInteger(1);
        AtomicInteger rowNumber = new AtomicInteger(1);
        AtomicInteger previousPoints = new AtomicInteger(-1);
        resultStore.entrySet().stream().sorted(new EntryComparator()).forEach(
                entry -> {
                    if (!(entry.getValue().get() == previousPoints.get())) {
                        rank.set(rowNumber.get());
                    }

                    writer.printf("%d. %s, %d pt%s",
                                       rank.get(),
                                       entry.getKey(),
                                       entry.getValue().get(),
                                       entry.getValue().get() == 1 ? System.lineSeparator()
                                                                   : "s" + System.lineSeparator());

                    rowNumber.incrementAndGet();
                    previousPoints.set(entry.getValue().get());
                });
    }

    static class EntryComparator implements Comparator<Entry<String, AtomicInteger>> {

        @Override
        public int compare(final Entry<String, AtomicInteger> entry1, final Entry<String, AtomicInteger> entry2) {

            var int1 = entry1.getValue().get();
            var int2 = entry2.getValue().get();

            if (int1 > int2) {
                return -1;
            } else if (int1 < int2) {
                return 1;
            }

            return entry1.getKey().compareToIgnoreCase(entry2.getKey());
        }
    }
}
