package edu.stanford.nlp.sempre;

public class ListFn extends edu.stanford.nlp.sempre.SemanticFn {
    private edu.stanford.nlp.sempre.ListValue listValue;
    public ListFn (edu.stanford.nlp.sempre.ListValue listValue){this.listValue=listValue;};
    @Override
    public edu.stanford.nlp.sempre.DerivationStream call(edu.stanford.nlp.sempre.Example ex, Callable c) {
        return new edu.stanford.nlp.sempre.SingleDerivationStream() {
            @Override
            public edu.stanford.nlp.sempre.Derivation createDerivation() {

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
