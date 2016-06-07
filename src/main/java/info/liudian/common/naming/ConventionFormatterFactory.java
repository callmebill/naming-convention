package info.liudian.common.naming;

public class ConventionFormatterFactory {
    ConventionFormatter create(Convention dest) {
        return new Converter(dest);
    }

    class Converter implements ConventionFormatter {
        private Convention dest;

        Converter(Convention dest) {
            this.dest = dest;
        }

        @Override
        public String format(String name) {
            return dest.format(name);
        }

        @Override
        public String format(String name, String prefix) {
            return dest.format(name, prefix);
        }
    }
}
