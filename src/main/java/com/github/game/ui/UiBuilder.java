package com.github.game.ui;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class UiBuilder {

	private final Terminal terminal;
	private final DefaultParser parser;
	private final LineReader reader;

	public UiBuilder() throws IOException {
		this.terminal = TerminalBuilder.builder().build();
		this.parser = new DefaultParser();
		this.reader = LineReaderBuilder.builder().terminal(terminal).parser(parser).build();

	}

	public Terminal getTerminal() {

		return terminal;

	}

	public DefaultParser getParser() {

		return parser;

	}

	public LineReader getReader() {

		return reader;

	}
}
