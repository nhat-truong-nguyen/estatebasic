package com.buildingmanager.repository.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.buildingmanager.entity.BuildingEntity;
import com.buildingmanager.mapper.Impl.BuildingEntityMapper;
import com.buildingmanager.repository.BuildingRepository;
import com.buildingmanager.util.ValidationUtil;

@Repository
public class BuildingRepositoryImpl extends BaseRepositoryImpl<BuildingEntity> implements BuildingRepository {

    public List<BuildingEntity> findBuildings(Map<String, String> params, List<String> types) {
		// Sử dụng alias cho ngắn gọn câu Query nhé
        StringBuilder finalQuery = new StringBuilder("SELECT * FROM building");
        buildQueryWithJoin(params, types, finalQuery);
        finalQuery.append("\nWHERE 1 = 1");
        buildQueryWithoutJoin(params, finalQuery);
        finalQuery.append("\nGROUP BY building.id");

        return query(finalQuery.toString(), new BuildingEntityMapper());
    }

    private StringBuilder buildQueryWithoutJoin(Map<String, String> params, StringBuilder whereQuery) {
        String name = params.getOrDefault("name", null);
        String floorArea = params.getOrDefault("floorArea", null);
        String ward = params.getOrDefault("ward", null);
        String street = params.getOrDefault("street", null);
        String numberOfBasement = params.getOrDefault("numberOfBasement", null);
        String direction = params.getOrDefault("direction", null);
        String level = params.getOrDefault("level", null);
        String rentPriceFrom = params.getOrDefault("rentPriceFrom", null);
        String rentPriceTo = params.getOrDefault("rentPriceTo", null);

        if (ValidationUtil.isNotBlank(name)) {
            whereQuery.append("\nAND building.name LIKE '%").append(name).append("%'");
        }

        if (ValidationUtil.isNotBlank(floorArea)) {
            whereQuery.append("\nAND building.floorarea = ").append(floorArea);
        }

        if (ValidationUtil.isNotBlank(ward)) {
            whereQuery.append("\nAND building.ward LIKE '%").append(ward).append("%'");
        }

        if (ValidationUtil.isNotBlank(street)) {
            whereQuery.append("\nAND building.street LIKE '%").append(street).append("%'");
        }

        if (ValidationUtil.isNotBlank(numberOfBasement)) {
            whereQuery.append("\nAND building.numberofbasement = ").append(numberOfBasement);
        }

        if (ValidationUtil.isNotBlank(direction)) {
            whereQuery.append("\nAND building.direction LIKE '%").append(direction).append("%'");
        }

        if (ValidationUtil.isNotBlank(level)) {
            whereQuery.append(String.format("\nAND building.level = '%s'", level));
        }

        if (ValidationUtil.isNotBlank(rentPriceFrom)) {
            whereQuery.append("\nAND building.rentprice >= ").append(rentPriceFrom);
        }

        if (ValidationUtil.isNotBlank(rentPriceTo)) {
            whereQuery.append("\nAND building.rentprice <= ").append(rentPriceTo);
        }

        return whereQuery;
    }

    public StringBuilder buildQueryWithJoin(Map<String, String> params, List<String> types,
                                            StringBuilder joinQuery) {

        String districtCode = params.getOrDefault("districtCode", null);
        String rentAreaFrom = params.getOrDefault("rentAreaFrom", null);
        String rentAreaTo = params.getOrDefault("rentAreaTo", null);
        String managerName = params.getOrDefault("managerName", null);
        String managerPhone = params.getOrDefault("managerPhone", null);


        if (ValidationUtil.isNotBlank(districtCode)) {
            joinQuery.append("\nJOIN district on building.districtid = district.id");
			// Sao không kết hợp WHERE luôn để đỡ check lại nhiều lần
        }

        if (ValidationUtil.isNotBlank(rentAreaFrom) || ValidationUtil.isNotBlank(rentAreaTo)) {
            joinQuery.append("\nJOIN rentarea on building.id = rentarea.buildingid");
        }

        for (String type : types) {
            if (ValidationUtil.isNotBlank(type)) {
                joinQuery.append("\nJOIN buildingrenttype on building.id = buildingrenttype.buildingid")
                        .append("\nJOIN renttype on buildingrenttype.renttypeid = renttype.id");
                break;
            }
        }

        if (ValidationUtil.isNotBlank(managerName) || ValidationUtil.isNotBlank(managerPhone)) {
            joinQuery.append("\nJOIN assignmentbuilding on building.id = assignmentbuilding.buildingid")
                    .append("\nJOIN users on users.id = assignmentbuilding.staffid");
        }

        if (ValidationUtil.isNotBlank(districtCode)) {
            joinQuery.append("\nAND district.code = ").append(String.format("'%s'", districtCode));
        }

        if (ValidationUtil.isNotBlank(rentAreaFrom)) {
            joinQuery.append("\nAND rentarea.value >= ")
                    .append(rentAreaFrom);
        }

        if (ValidationUtil.isNotBlank(rentAreaTo)) {
            joinQuery.append("\nAND rentarea.value <= ")
                    .append(rentAreaTo);
        }

		// Sao không dùng thẳng String.join luôn mà còn phải check count gì nữa đó quý khách
        int countEmptyValue = 0;
        for (int i = 0; i < types.size(); i++) {
            if (ValidationUtil.isBlank(types.get(i))) {
                countEmptyValue++;
            }
            types.set(i, String.format("'%s'", types.get(i)));
        }

        if (countEmptyValue < types.size()) {
            joinQuery.append(String.format("\nAND renttype.code IN(%s)", String.join(", ", types)));
        }

        if (ValidationUtil.isNotBlank(managerName)) {
            joinQuery.append("\nAND users.fullname LIKE '%")
                    .append(managerName)
                    .append("%'");
        }

        if (ValidationUtil.isNotBlank(managerPhone)) {
            joinQuery.append("\nAND users.phone LIKE '%")
                    .append(managerPhone)
                    .append("%'");
        }

        return joinQuery;
    }
}
