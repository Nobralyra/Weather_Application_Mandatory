
package dat19v2.mandatory.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
 * and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * https://projectlombok.org/features/all
 */
@Data
@SuppressWarnings("unused")
@AllArgsConstructor
@NoArgsConstructor
public class SysDTO
{
    private String country;
    private long id;
    private double message;
    private long sunrise;
    private long sunset;
    private long type;
}