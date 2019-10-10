package springBoot.test1.mapper;

import springBoot.pojo.TaskInitiateAssociation;

import java.util.List;



public interface UserMapper {
  /*  @Select("select  * from HEX_CJOP_AIM_TASK_ASSOCIATION")
      List<TaskInitiateAssociation> selectList();*/

      List<TaskInitiateAssociation> selectList(String initateUid);

}
