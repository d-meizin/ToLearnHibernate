package meizin.ltd.Music;

import jakarta.persistence.*;

@Entity
@Table(name = "music_band")
public class MusicBand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = band_id)
	private long id;
	
	@Column(name = "band_name")
	private String bandName;
	
	@Column(name = "people_count")
	private int peopleCount;
	
	public MusicBand() {	
	}
	
	public MusicBand(String bandName, int peopleCount) {
		this.bandName = bandName;
		this.peopleCount = peopleCount;
	}

}
