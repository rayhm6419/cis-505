package Module_6;
import java.util.*;

public class MemComposerDao implements ComposerDao{ 
    
    private List<Composer> composers;

    public MemComposerDao(){
        composers = new ArrayList<Composer>();
        Composer composer1 = new Composer(1007,"Ludwig Van Beethoven","Classical");
        Composer composer2 = new Composer(1008, "Johann Sebastian Bach", "Classical");
        Composer composer3 = new Composer(1009, "Wolfgang Amadeus Mozart", "Classical");
        Composer composer4 = new Composer (1010, "Johannes Brahms", "Classical");
        Composer composer5 = new Composer(1011, "Joseph Haydn", "Classical");
        composers.add(composer1);
        composers.add(composer2);
        composers.add(composer3);
        composers.add(composer4);
        composers.add(composer5);

    }
    @Override
    public List<Composer> findAll(){
        System.out.println("  --DISPLAYING COMPOSERS--");
        return composers;
    }

    @Override
    public Composer findBy(Integer id){
        System.out.println("  --DISPLAYING COMPOSERS--");
        for (Composer composer : composers){ 
            if (id.equals(composer.getId())){ 
                return composer;
            }
        }
        return null;
    }
   
    @Override
    public void insert(Composer newComposer){
        composers.add(newComposer);
    }
}
