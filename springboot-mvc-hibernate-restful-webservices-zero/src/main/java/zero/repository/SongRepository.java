package zero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import zero.model.Song;

@Repository("songRepository")
public interface SongRepository extends CrudRepository<Song, Integer>{
	public List<Song> findByShortName(String lastName); // phải ghi đúng là findByShortName vì có biến tên là shortName
}
