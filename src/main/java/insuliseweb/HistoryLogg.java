package insuliseweb;

import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
public class HistoryLogg {
    private final long id;
    private final Date loggDate;
    private final String message;
    private final Double bloodSugar;
    private final Double carbs;
}
