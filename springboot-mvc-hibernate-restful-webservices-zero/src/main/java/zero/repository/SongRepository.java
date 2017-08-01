package zero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import zero.model.Song;

/**
 * @author Thuat T Nguyen
 * @version 08/01/2017
 */
@Repository("songRepository")
public interface SongRepository extends CrudRepository<Song, Integer>{
	public List<Song> findByShortName(String shortName); // phải ghi đúng là findByShortName vì có biến tên là shortName
}
