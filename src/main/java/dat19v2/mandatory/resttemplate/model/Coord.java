
package dat19v2.mandatory.resttemplate.model;

import lombok.Data;

/**
 * @Data
 * All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields,
 * and @Setter on all non-final fields, and @RequiredArgsConstructor!
 * https://projectlombok.org/features/all
 */
@Data
@SuppressWarnings("unused")
public class Coord
{
    private long lat;
    private long lon;
}
