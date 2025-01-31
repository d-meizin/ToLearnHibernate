package meizin.ltd.Music;

import jakarta.persistence.*;

@Entity
@Table(name = "music_artist")
public class MusicArtist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = artist_id)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "band_id")
	private long bandId;
	
	public MusicArtist() {	
	}
	
	public MusicArtist(Srting firstName, String lastName, int age, long bandId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.bandId = bandId;
	}


}
