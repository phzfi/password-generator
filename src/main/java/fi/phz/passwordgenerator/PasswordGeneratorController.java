package fi.phz.passwordgenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/v1")
public class PasswordGeneratorController {

    @GetMapping("/password")
    public String generatePassword() {
        try {
            ProcessBuilder builder = new ProcessBuilder("apg");
            builder.redirectErrorStream(true);
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String password = reader.readLine();
            process.waitFor();
            return password;
        } catch (Exception e) {
            return "Error generating password: " + e.getMessage();
        }
    }
}
