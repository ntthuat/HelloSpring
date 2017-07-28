package zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zero.model.Song;
import zero.repository.SongRepository;

@Service("songService")
public class SongService {
	
	@Autowired
	private SongRepository songRepository;
	
	public Iterable<Song> findByShortName(String lastName){
		return songRepository.findByShortName(lastName);
	}
}
