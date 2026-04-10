package ca.sheridancollege.rajputja.poster.boostrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.rajputja.poster.data.Poster;
import ca.sheridancollege.rajputja.poster.services.PosterService;

@Component
public class PosterBootstrapdata implements CommandLineRunner {

    private final PosterService posterService;

    public PosterBootstrapdata(PosterService posterService) {
        this.posterService = posterService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (posterService.findAll().size() > 0) {
            return;
        }

        posterService.save(Poster.builder()
                .name("Starry Night")
                .price(120.0)
                .quantity(10)
                .employeeName("Vincent van Gogh")
                .build());

        posterService.save(Poster.builder()
                .name("Guernica")
                .price(150.0)
                .quantity(8)
                .employeeName("Pablo Picasso")
                .build());

        posterService.save(Poster.builder()
                .name("Mona Lisa")
                .price(200.0)
                .quantity(5)
                .employeeName("Leonardo da Vinci")
                .build());

        posterService.save(Poster.builder()
                .name("Water Lilies")
                .price(100.0)
                .quantity(12)
                .employeeName("Claude Monet")
                .build());

        posterService.save(Poster.builder()
                .name("The Scream")
                .price(130.0)
                .quantity(7)
                .employeeName("Edvard Munch")
                .build());

        posterService.save(Poster.builder()
                .name("The Kiss")
                .price(110.0)
                .quantity(9)
                .employeeName("Gustav Klimt")
                .build());

        posterService.save(Poster.builder()
                .name("Girl with a Pearl Earring")
                .price(95.0)
                .quantity(15)
                .employeeName("Johannes Vermeer")
                .build());

        posterService.save(Poster.builder()
                .name("The Night Watch")
                .price(140.0)
                .quantity(6)
                .employeeName("Rembrandt")
                .build());

        posterService.save(Poster.builder()
                .name("American Gothic")
                .price(85.0)
                .quantity(20)
                .employeeName("Grant Wood")
                .build());

        posterService.save(Poster.builder()
                .name("The Persistence of Memory")
                .price(160.0)
                .quantity(4)
                .employeeName("Salvador Dalí")
                .build());

        System.out.println("Posters loaded into H2 database!");
    }
}