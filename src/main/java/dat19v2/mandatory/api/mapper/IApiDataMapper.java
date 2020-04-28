package dat19v2.mandatory.api.mapper;

import dat19v2.mandatory.api.domain.*;
import dat19v2.mandatory.model.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DTO classes are used to transfer data.
 * We do not want to expose our Entity classes to the client (RestApiDataController and ViewDataController),
 * because there can be data we do not want them to see or not needed.
 */
@Mapper
public interface IApiDataMapper
{
    IApiDataMapper INSTANCE = Mappers.getMapper(IApiDataMapper.class);

    /**
     * @Mapping maps DTO classes to there respective Entity classes and fields
     * @param apiData
     * @return ApiDataDTO
     */
    @Mapping(target = "timezone", source = "timezone")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "dt", source = "dt")
    @Mapping(target = "cod", source = "cod")
    @Mapping(target = "base", source = "base")
    @Mapping(target = "visibility", source = "visibility")
    @Mapping(target = "createdDate", source = "createdDate")
    @Mapping(target = "apiDataUrl", source = "")

    @Mapping(target = "cloudsDTO", source = "clouds")
    @Mapping(target = "coordDTO", source = "coord")
    @Mapping(target = "mainDTO", source = "mainModel")
    @Mapping(target = "sysDTO", source = "sys")
    @Mapping(target = "weatherDTOList", source = "weatherList")
    @Mapping(target = "windDTO", source = "wind")

    @Mapping(target = "cloudsDTO.all", source = "clouds.all")
    @Mapping(target = "coordDTO.lat", source = "coord.lat")
    @Mapping(target = "coordDTO.lon", source = "coord.lon")
    @Mapping(target = "mainDTO.feelsLike", source = "mainModel.feelsLike")
    @Mapping(target = "mainDTO.humidity", source = "mainModel.humidity")
    @Mapping(target = "mainDTO.pressure", source = "mainModel.pressure")
    @Mapping(target = "mainDTO.temp", source = "mainModel.temp")
    @Mapping(target = "mainDTO.tempMax", source = "mainModel.tempMax")
    @Mapping(target = "mainDTO.tempMin", source = "mainModel.tempMin")
    @Mapping(target = "sysDTO.id", source = "sys.id")
    @Mapping(target = "sysDTO.sunrise", source = "sys.sunrise")
    @Mapping(target = "sysDTO.sunset", source = "sys.sunset")
    @Mapping(target = "sysDTO.type", source = "sys.type")
    @Mapping(target = "windDTO.deg", source = "wind.deg")
    @Mapping(target = "windDTO.speed", source = "wind.speed")
    ApiDataDTO apiDataToApiDataDTO(ApiData apiData);

    /**
     * Takes all the @Mapping and reverse them, so less code the programmer should write
     * @param apiDataDTO
     * @return ApiData
     */
    @InheritInverseConfiguration
    ApiData apiDataDTOToApiData(ApiDataDTO apiDataDTO);

}
