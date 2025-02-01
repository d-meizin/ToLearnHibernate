package meizin.ltd.Music;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "music_band")
public class MusicBand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "band_id")
	private long bandId;
	
	@Column(name = "band_name")
	private String bandName;
	
	@Column(name = "people_count")
	private int peopleCount;
	
	@OneToMany(mappedBy = "band", cascade = CascadeType.PERSIST)
	private List<MusicArtist> artists = new ArrayList<>();
	
	public void addArtistToBand(MusicArtist artist) {
		artists.add(artist);
		artist.setBand(this);
	}
	
	public MusicBand() {	
	}
	
	public MusicBand(String bandName, int peopleCount) {
		this.bandName = bandName;
		this.peopleCount = peopleCount;
	}
	
	// Getters and Setters
	
	public long getBandId() {
		return bandId;
	}
	
	public void setBandId(long bandId) {
		this.bandId = bandId;
	}
	
	public String getBandName() {
		return bandName;
	}
	
	public void setBandName(String bandName) {
		this.bandName = bandName;
	}
	
	public int getPeopleCount() {
		return peopleCount;
	}
	
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	
	public List<MusicArtist> getArtists() {
		return artists;
	}
	
	public void setArtists(List<MusicArtist> artists) {
		this.artists = artists;
	}

}
