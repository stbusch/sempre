package edu.stanford.nlp.sempre;

public class ListFn extends SemanticFn {
    private ListValue listValue;
    public ListFn (ListValue listValue){this.listValue=listValue;};
    @Override
    public DerivationStream call(Example ex, Callable c) {
        return new SingleDerivationStream() {
            @Override
            public Derivation createDerivation() {

                for (int i = 0; i < c.getChildren().size(); i++) {
                    listValue.values.add(c.getChildren().get(i).getValue());
                }
                return new Derivation.Builder()
                        .withCallable(c)
                        .formula(new ValueFormula<>(listValue))
                        .createDerivation();
            }
        };
    }
}
