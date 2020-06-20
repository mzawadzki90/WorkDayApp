package michal.zawadzki.workdayapp.api.worker;

import michal.zawadzki.workdayapp.model.Role;

public class SimplifiedWorkerDtoBuilder {

    private int id;
    private Role role;
    private String email;
    private String firstName;
    private String lastName;

    public SimplifiedWorkerDtoBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public SimplifiedWorkerDtoBuilder withRole(Role role) {
        this.role = role;
        return this;
    }

    public SimplifiedWorkerDtoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public SimplifiedWorkerDtoBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public SimplifiedWorkerDtoBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public SimplifiedWorkerDto build() {
        return new SimplifiedWorkerDto(id, role, email, firstName, lastName);
    }

}