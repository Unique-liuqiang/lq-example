package springBoot.test2.service;

import springBoot.pojo.EquityAssets;
import springBoot.pojo.TaskInitiateAssociation;

import java.util.List;

public interface ODSEquitySerice {

    List<EquityAssets> selectEquityPerson();
}
