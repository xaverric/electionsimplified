package cz.jilek.daniel.electionsimplified.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitialDataSet {

    private final List<Dataset> datasets;

    @Autowired
    public InitialDataSet(List<Dataset> datasets) {
        this.datasets = datasets;
    }

    public InitializingBean load() {
        datasets.forEach(Dataset::load);
        return null;
    }

}
