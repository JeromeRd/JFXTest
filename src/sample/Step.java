package sample;

public enum Step {
    INSTALL("Mvn install"),
    DEPLOY_KEY("Deploiement de le clé Linxo"),
    DEPLOY_LIB_INTO_PFM("Deploiement dans PFM"),
    DEPLOY_LIB_INTO_JOB("Deploiement dans JOB"),
    DEPLOY_LIB_INTO_W1("Deploiement dans WORKER1");

    private String name;

    Step(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}