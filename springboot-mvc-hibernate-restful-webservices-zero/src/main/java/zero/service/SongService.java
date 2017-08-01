package zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zero.model.Song;
import zero.repository.SongRepository;

/**
 * @author Thuat T Nguyen
 * @version 08/01/2017
 */
@Service("songService")
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
	public Iterable<Song> findByShortName(String shortName){
		return songRepository.findByShortName(shortName);
	}
}
