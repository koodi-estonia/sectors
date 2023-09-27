package ee.koodi.helmes.user.api;


import java.util.List;

public class UserDto {

    private String name;

    private boolean consent;

    private List<Long> selectedSectorsIds;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConsent() {
        return consent;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public List<Long> getSelectedSectorsIds() {
        return selectedSectorsIds;
    }

    public void setSelectedSectorsIds(List<Long> selectedSectorsIds) {
        this.selectedSectorsIds = selectedSectorsIds;
    }
}
