package fr.lacombe.socrates.mock;

import fr.lacombe.socrates.Venue;

import java.time.LocalDateTime;

public class VenueMock extends Venue {

    private boolean isDeskOpen;
    private boolean isKitchenClosed;

    public VenueMock(final LocalDateTime kitchenClosingTime, final LocalDateTime deskClosingTime) {
        super(kitchenClosingTime, deskClosingTime);
    }

    public void whenCallingIsDeskOpenThenReturn(final boolean isDeskOpen) {
        this.isDeskOpen = isDeskOpen;
    }

    public void whenCallingIsKitchenClosedThenReturn(final boolean isKitchenClosed) {
        this.isKitchenClosed = isKitchenClosed;
    }

    @Override
    public boolean isDeskOpen(final LocalDateTime dateTime) {
        return isDeskOpen;
    }

    @Override
    public boolean isKitchenClosed(final LocalDateTime dateTime) {
        return isKitchenClosed;
    }
}
