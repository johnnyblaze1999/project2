import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {

    private boolean[] followees;
    private Set<Transaction> pendingTransactions;

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
        this.followees = new boolean[numRounds];
        this.pendingTransactions = new HashSet<>();
    }

    public void setFollowees(boolean[] followees) {
        // IMPLEMENT THIS
        this.followees = new boolean[followees.length];
        System.arraycopy(followees, 0, this.followees, 0, followees.length);
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        // IMPLEMENT THIS
        this.pendingTransactions = new HashSet<>(pendingTransactions);
    }

    public Set<Transaction> getProposals() {
        // IMPLEMENT THIS
        return this.pendingTransactions;
    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) {
        // IMPLEMENT THIS
        for (Integer[] candidate : candidates){
            int transactionId = candidate[0];
            Transaction transaction = new Transaction(transactionId);
            this.pendingTransactions.add(transaction);
        }
    }
}
