package com.arqhexagonal.tasks.infrastructure.adapters;

import com.arqhexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.arqhexagonal.tasks.domain.ports.output.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrlToDo = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderToDo> response = restTemplate.getForEntity(apiUrlToDo, JsonPlaceHolderToDo.class);
        JsonPlaceHolderToDo todo = response.getBody();
        if (todo == null) {
            return null;
        }

        String apiUrlUsers = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceholderUser> responseUser = restTemplate.getForEntity(apiUrlUsers, JsonPlaceholderUser.class);
        JsonPlaceholderUser user = responseUser.getBody();

        if (user == null) {
            return null;
        }

        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());

    }

    private static class JsonPlaceHolderToDo {
        private  Long id;
        private  Long userId;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    private static class JsonPlaceholderUser {
        private  Long id;
        private  String name;
        private  String email;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
