package handlers;


import components.Counter;
import dev.mccue.microhttp.handler.RouteHandler;
import dev.mccue.microhttp.html.HtmlResponse;
import org.microhttp.Request;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DecrementHandler extends RouteHandler {
    private final AtomicInteger count;

    public DecrementHandler(AtomicInteger count) {
        super("POST", Pattern.compile("/decrement"));
        this.count = count;
    }

    @Override
    protected HtmlResponse handleRoute(
            Matcher matcher,
            Request request
    ) {
        return new HtmlResponse(new Counter(count.decrementAndGet()));
    }
}

