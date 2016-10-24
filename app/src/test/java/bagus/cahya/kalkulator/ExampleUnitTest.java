package bagus.cahya.kalkulator;

import org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    MainActivity mainActivity;

    @Before
    public void setUp(){
        mainActivity = new MainActivity();
    }
    @Test
    public void tambah_benar() throws Exception {
        assertEquals(14, mainActivity.tambah(5,9));
    }

    @Test
    public void tambah_salah() throws Exception {
        assertNotEquals(78,mainActivity.tambah(7,8));
    }

    @Test
    public void kurang_benar() throws Exception {
        assertThat("pengurangan benar",56,equalTo(mainActivity.kurang(59,3)));
    }

}