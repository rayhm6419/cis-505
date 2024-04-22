import java.util.ArrayList;
import java.util.List;

public class MemComposerDAO implements ComposerDAO {
    private List<Composer> composers;

    public MemComposerDAO(){
        composers = new ArrayList<>();
        composers.add(new Composer(1, "Bach", "Classical"));
        composers.add(new Composer(2, "Mozart", "Classical"));
        composers.add(new Composer(3, "Beethoven", "Classical"));
        composers.add(new Composer(4, "Chopin", "Romantic"));
        composers.add(new Composer(5, "Debussy", "Impressionist"));
    }

    @Override
    public List<Composer> findAll(){
       return new ArrayList<>(composers);
    }

    @Override
    public Composer findBy(Integer id){
        for (Composer composer : composers){
            if (composer.getId() == id){
                return composer;
            }
        }
        return null;
    }

    @Override
    public  void insert(Composer composer){
        composers.add(composer);
    }
}
