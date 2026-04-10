package ca.sheridancollege.rajputja.artist.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.rajputja.artist.domain.Artist;
import ca.sheridancollege.rajputja.artist.services.ArtistService;

@Component

public class ArtistBootstrapData  implements  CommandLineRunner {

	private final ArtistService artistService;

	public ArtistBootstrapData(ArtistService artistService) {
		this.artistService = artistService;
	}

	 @Override
	    public void run(String... args) throws Exception{
		if (artistService.findAll().size() > 0) {
			return;
		}

		artistService.save(Artist.builder().name("Vincent van Gogh").build());
		artistService.save(Artist.builder().name("Pablo Picasso").build());
		artistService.save(Artist.builder().name("Leonardo da Vinci").build());
		artistService.save(Artist.builder().name("Claude Monet").build());

		System.out.println("Artists loaded into H2 database!");
	}

}
