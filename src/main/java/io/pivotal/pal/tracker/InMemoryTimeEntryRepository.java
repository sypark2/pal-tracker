package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    // Inmemory Repo
    private HashMap<Long, TimeEntry> repo = new HashMap<>();
    private Long id = 0L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(++id);
        repo.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {

        return repo.get(id);
    }

    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(repo.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry temp = null;
        temp = repo.get(id);
        System.out.println("Time Entry T3emp :"+temp);
        System.out.println("TimeEntry Entered "+timeEntry);
        if (temp != null){
            temp.setDate(timeEntry.getDate());
            temp.setHours(timeEntry.getHours());
            temp.setProjectId(timeEntry.getProjectId());
            temp.setUserId(timeEntry.getUserId());
            temp.setId(id);
            System.out.println("Time Entry Updated T3emp :"+temp);
            repo.put(id, temp);
        }
        return temp;
    }

    @Override
    public void delete(Long id) {
        repo.remove(id);
    }
}
