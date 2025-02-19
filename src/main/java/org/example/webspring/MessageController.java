package org.example.webspring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api")
@RestController
public class MessageController {

    // Liste zum Speichern der Nachrichten
    private List<Message> messages = new ArrayList<>();

    // GET-Anfrage, um alle Nachrichten abzurufen
    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messages;
    }

    // POST-Anfrage, um eine neue Nachricht zu speichern
    @PostMapping("/messages")

    public Message addMessage(@RequestBody Message message) {
        // Generieren einer zufälligen ID für die Nachricht
        String randomId = UUID.randomUUID().toString();

        // Setzen der generierten ID in die Nachricht
        message.setId(randomId);

        // Hinzufügen der Nachricht zur Liste
        messages.add(message);

        // Rückgabe der hinzugefügten Nachricht mit der generierten ID
        return message;
    }

    @DeleteMapping("/messages/{id}")
    public String deleteMessage(@PathVariable String id) {
        // Suche nach der Nachricht mit der gegebenen ID und Entfernen
        boolean removed = messages.removeIf(message -> message.getId().equals(id));

        if (removed) {
            return "Nachricht mit ID " + id + " wurde erfolgreich gelöscht.";
        } else {
            return "Nachricht mit ID " + id + " konnte nicht gefunden werden.";
        }
    }
}