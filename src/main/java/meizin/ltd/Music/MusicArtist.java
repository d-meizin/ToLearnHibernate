package meizin.ltd.Music;

import jakarta.persistence.*;

@Entity
@Table(name = "music_artist")
public class MusicArtist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artist_id")
	private Long artistId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	//@Column(name = "band_id")
	//private Long bandId;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "band_id")
	private MusicBand band;
	
	public MusicArtist() {	
	}
	
	public MusicArtist(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	// Getters and Setters
	
	public Long getArtistId() {
		return artistId;
	}
	
	public void setArtistId(Long artistId) {
		this.artistId = artistId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	/*public long getBandId() {
		return bandId;
	}
	
	public void setBandId(long bandId) {
		this.bandId = bandId;
	}*/
	
	public MusicBand getBand() {
		return band;
	}
	
	public void setBand(MusicBand band) {
		this.band = band;
	}
	
}
