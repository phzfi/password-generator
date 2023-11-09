package fi.phz.passwordgenerator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/api/v1/password")
public class PasswordGeneratorController {

    @PostMapping("")
    public String generatePassword() {
        try {
            Process process = new ProcessBuilder("apg").redirectErrorStream(true).start();
            String password;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                password = reader.readLine();
                process.waitFor();
            }
            return password;

        } catch (Exception e) {
            return "Error generating password: " + e.getMessage();
        }
    }
}
