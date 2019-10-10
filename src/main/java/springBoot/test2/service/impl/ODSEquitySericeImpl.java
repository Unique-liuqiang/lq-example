package springBoot.test2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springBoot.pojo.EquityAssets;
import springBoot.test2.mapper.ODSEquityMapper;
import springBoot.test2.service.ODSEquitySerice;

import java.util.List;

@Service
public class ODSEquitySericeImpl implements ODSEquitySerice {

    @Autowired
    ODSEquityMapper odsEquityMapper;

    @Override
    public List<EquityAssets> selectEquityPerson() {
        return odsEquityMapper.selectEquityPerson();
    }
}
