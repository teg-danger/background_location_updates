package io.gjg.backgroundlocationupdates.persistence;



import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface LocationDao {

    @Query("SELECT * FROM location")
    List<LocationEntity> getAll();

    @Query("SELECT * FROM location WHERE read_count = 0")
    List<LocationEntity> getUnread();

    @Query("SELECT COUNT(*) from location")
    int countLocationTraces();

    @Query("SELECT COUNT(*) from location where read_count = 0")
    int countLocationTracesUnread();

    @Query("UPDATE location SET read_count = read_count + 1 WHERE id in (:ids)")
    int markAsRead(List<Integer> ids);

    @Insert
    void insertAll(LocationEntity... entities);

    @Delete
    void delete(LocationEntity entity);
}
