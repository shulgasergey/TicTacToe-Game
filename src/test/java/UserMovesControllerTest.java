import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import sergey.shulga.UserMovesController;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserMovesControllerTest {

    //Passed
    @Test
    @Disabled
    public void checkInputTest() throws IOException {
        assertFalse(UserMovesController.checkInput(3, 0));
    }
}