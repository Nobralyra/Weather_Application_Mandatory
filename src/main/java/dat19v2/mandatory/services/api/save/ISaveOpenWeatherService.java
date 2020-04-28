package dat19v2.mandatory.services.api.save;

/**
 * Generic save interface to all save Enities
 * @param <T>
 */
public interface ISaveOpenWeatherService<T>
{
    void save(T t);
}
