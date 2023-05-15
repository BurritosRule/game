package com.github.game.ui;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class UiBuilder {

	public Terminal createTerminal() throws IOException {
		Terminal terminal = TerminalBuilder.builder().build();
		return terminal;
	}

	public DefaultParser createParser() {
		DefaultParser parser = new DefaultParser();
		return parser;
	}

	public LineReader createReader(Terminal terminal, DefaultParser parser) {
		LineReader reader = LineReaderBuilder.builder().terminal(terminal).parser(parser).build();
		return reader;
	}

}
