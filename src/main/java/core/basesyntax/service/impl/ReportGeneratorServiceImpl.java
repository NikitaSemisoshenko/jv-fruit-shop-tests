package core.basesyntax.service.impl;

import core.basesyntax.service.ReportGeneratorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private static final String REPORT_STRINGS = "fruits,quantity";

    @Override
    public List<String> generate(Map<String, Integer> fruitsAtStorageMap) {
        if (fruitsAtStorageMap == null) {
            throw new RuntimeException("Input map can't be null");
        }
        List<String> reportStrings = new ArrayList<>();
        reportStrings.add(REPORT_STRINGS);
        fruitsAtStorageMap.forEach((key, value) -> reportStrings.add(key + "," + value));
        return reportStrings;
    }
}
