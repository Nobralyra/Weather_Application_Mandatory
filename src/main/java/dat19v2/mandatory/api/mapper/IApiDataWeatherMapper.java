package dat19v2.mandatory.api.mapper;

import dat19v2.mandatory.api.domain.ApiDataDTO;
import dat19v2.mandatory.resttemplate.model.ApiData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IApiDataWeatherMapper
{
    IApiDataWeatherMapper INSTANCE = Mappers.getMapper(IApiDataWeatherMapper.class);

    ApiDataDTO apiDataToApiDataDTO(ApiData apiData);

    ApiData apiDataDTOToApiData(ApiDataDTO apiDataDTO);

}
