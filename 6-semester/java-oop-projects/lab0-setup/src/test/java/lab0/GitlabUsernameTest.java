package lab0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.jupiter.api.Test;

public class GitlabUsernameTest {

    @Test
    public void validGitlabUsernameTest() {
        // Gitlab username should not be over 40 characters
        String username = GitlabUsername.gitlabUsername;
        if (username.length() > 40)
            fail("Username is too long");

        // No white spaces in the username
        if (username.contains(" "))
            fail("Username must not contain white spaces");

        // First character in username must be '@'
        char firstChar = username.charAt(0);
        assertEquals('@', firstChar);

        // Prints username to file to be fetched by course instructor
        try {
            printUsernameToFile(username);
        }
        catch (FileNotFoundException e) {
            fail("File could not be printed to file. Ask group leader for help");
        }
    }

    public void printUsernameToFile(String username) throws FileNotFoundException {
        File file = new File("username.txt");
        PrintWriter writer = new PrintWriter(file);
        writer.write(username);
        writer.close();
    }

}
