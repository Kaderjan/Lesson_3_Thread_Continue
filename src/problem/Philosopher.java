package problem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Philosopher {
    private boolean isForkAvailable;
    private boolean doesEat;
    private boolean hasOneFork;
    private boolean hasTwoFork;
}
