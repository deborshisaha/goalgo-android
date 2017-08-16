package com;

import com.algorithms.arrays.*;
import com.algorithms.binarysearch.*;
import com.algorithms.dp.CountNumberOfBinaryWithoutConsecutive1s;
import com.algorithms.dp.CuttingRod;
import com.algorithms.dp.DiceWays;
import com.algorithms.dp.DistinctSubsequences;
import com.algorithms.dp.DungeonGame;
import com.algorithms.dp.EditDistance;
import com.algorithms.dp.KnapSack01Calculator;
import com.algorithms.dp.LongestCommonSubsequence;
import com.algorithms.dp.LongestCommonSubstring;
import com.algorithms.dp.LongestIncreasingSubequence;
import com.algorithms.dp.LongestIncreasingSubsequence;
import com.algorithms.dp.LongestPalindromeSubsequence;
import com.algorithms.dp.MNPathMatrix;
import com.algorithms.dp.MaxSumIncreasingSubsequence;
import com.algorithms.dp.MaxSumSubsequenceNonAdjacent;
import com.algorithms.dp.MinimumCostPath;
import com.algorithms.dp.MinimumJumpToReachEnd;
import com.algorithms.dp.MinimumNumberOfCoins;
import com.algorithms.dp.NumberOfWaysToChange;
import com.algorithms.dp.NumberOfWaysToScorePoints;
import com.algorithms.dp.PalindromePartitioning;
import com.algorithms.dp.RegexMatcher;
import com.algorithms.dp.StairCaseFibonacci;
import com.algorithms.dp.StockBuySellKtransactions;
import com.algorithms.dp.StringInterleaving;
import com.algorithms.dp.SubsetSum;
import com.algorithms.dp.SumQueryIn2DImmutableArray;
import com.algorithms.dp.TextJustifier;
import com.algorithms.dp.WeightedJobScheduler;
import com.algorithms.dp.WordsColaesced;
//import com.algorithms.graph.BridgeFinder;
import com.algorithms.graph.CyclicUndirectedGraphCycleDetector;
import com.algorithms.graph.DisjointSet;
import com.algorithms.graph.TopologicalSort;
import com.algorithms.greedy.ActivitySelection;
import com.algorithms.greedy.ConnectNRopes;
import com.algorithms.greedy.FractionalKnapsack;
import com.algorithms.greedy.JobSequenceProblem;
import com.algorithms.greedy.MinimumNumberOfPlatforms;
import com.algorithms.linkedlist.DeleteDuplicatesInALinkedList;
import com.algorithms.linkedlist.DeleteNAfterMNodes;
import com.algorithms.linkedlist.ReverseAlternateKNodes;
import com.algorithms.randomization.Rand7UsingRand5;
import com.algorithms.randomization.RandomCountrySelectionByPopulation;
import com.algorithms.randomization.ReservoirSampler;
import com.algorithms.randomization.Shuffler;
import com.algorithms.recursion.AllCombinationsAtDistanceK;
import com.algorithms.recursion.BracketChecker;
import com.algorithms.recursion.ChainWordsToCircle;
import com.algorithms.recursion.LongestAbsolutePath;
import com.algorithms.recursion.NQueen;
import com.algorithms.recursion.RestoreIPAddress;
import com.algorithms.recursion.SudokuSolver;
import com.algorithms.recursion.TripPlanner;
import com.algorithms.recursion.WordsPossibleUsingAPhoneNumber;
import com.algorithms.string.*;
import com.algorithms.suffixprefix.TST;
import com.algorithms.suffixprefix.Trie;
import com.algorithms.trees.BTtoLinkedList;
import com.algorithms.trees.BinarySearchTree;
import com.algorithms.trees.BinarySearchTreeValidator;
import com.algorithms.trees.BinaryTree;
import com.algorithms.trees.BoundaryTraversal;
import com.algorithms.trees.HuffmanEncoding;
import com.algorithms.trees.LeafStripper;
import com.algorithms.trees.NodesWithNoSibling;
import com.algorithms.trees.PrintNodeAtDistanceKFromANode;
import com.algorithms.trees.SegmentTree;
import com.algorithms.trees.TreeFromPreorderAndInorder;
import java.util.List;

/**
 *
 * @author dsaha
 */
public class Algorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ThreeSum threeSum = new ThreeSum();
        int[] array = new int[]{-1, 0, 2, 1, 1, 4, 3};
        List<List<Integer>> result = threeSum.getListOfListOfIntegers(5, array);

        if (result.size() > 0) {

            result.forEach((list) -> {
                list.forEach((lis) -> {
                    System.out.print(lis + ",");
                });

                System.out.print("\n");
            });
        }

        SmallestWindowContaingAllCharacters.driver();
        KMPSubstringSearch.driver();
        AbbreviationChecker.driver();
        LongestPalindromeSubstring.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| LongestSubstringWithKDistinctCharacters                 |");
        System.out.println("+---------------------------------------------------------+");
        LongestSubstringWithKDistinctCharacters.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Palindrome Pair                                         |");
        System.out.println("+---------------------------------------------------------+");
        PalindromePair.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| BestTimeToBuyAndSellAStock                              |");
        System.out.println("+---------------------------------------------------------+");
        BestTimeToBuyAndSellAStock.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| SelfCrossing                                            |");
        System.out.println("+---------------------------------------------------------+");
        SelfCrossing.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Median Of Two Sorted Arrays                             |");
        System.out.println("+---------------------------------------------------------+");
        MedianOfTwoSortedArrays.driver();

        TotalScore.driver();
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Delete Duplicates in a linked list                      |");
        System.out.println("+---------------------------------------------------------+");
        DeleteDuplicatesInALinkedList.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Delete M nodes after N nodes                            |");
        System.out.println("+---------------------------------------------------------+");
        DeleteNAfterMNodes.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Reverse k Nodes                                         |");
        System.out.println("+---------------------------------------------------------+");
        ReverseAlternateKNodes.driver();

        KnapSack01Calculator.driver();

        WeightedJobScheduler.driver();

        StairCaseFibonacci.driver();
        SubsetSum.driver();
        MinimumCostPath.driver();

        TopologicalSort.driver();
        DisjointSet.driver();
        CyclicUndirectedGraphCycleDetector.driver();

        //BridgeFinder.driver();
        BinarySearchTreeValidator.driver();

        System.out.println("Diameter: " + BinaryTree.createNotBST().diameter());

        LeafStripper.driver();

        HuffmanEncoding.driver();

        Shuffler.driver();

        Rand7UsingRand5.driver();

        ReservoirSampler.driver();

        RandomCountrySelectionByPopulation.driver();

        BracketChecker.driver();

        SudokuSolver.driver();

        //WordsPossibleUsingAPhoneNumber.driver();
        //NQueen.driver();
        TripPlanner.driver();
        System.out.println();
        RestoreIPAddress.driver();

        LongestAbsolutePath.driver();

        AllCombinationsAtDistanceK.driver();

        ChainWordsToCircle.driver();

        ArithmeticProgressionSearch.driver();

        MissingNumberInConsecutiveNumbers.driver();

        PeakElementFinder.driver();

        BinarySearch.driver();

        FirstOccurrenceOfNumberInSortedArray.driver();

        MedianFinderIn2SortedArrays.driver();

        TST.driver();

        Trie.driver();

        SegmentTree.driver();

        BTtoLinkedList.driver();

        TreeFromPreorderAndInorder.driver();

        BinarySearchTree.driver();

        PrintNodeAtDistanceKFromANode.driver();

        NodesWithNoSibling.driver();

        BoundaryTraversal.driver();

        TextJustifier.driver();

        EditDistance.driver();

        NumberOfWaysToChange.driver();

        WordsColaesced.driver();

        CuttingRod.driver();

        DiceWays.driver();

        MinimumNumberOfCoins.driver();

        CountNumberOfBinaryWithoutConsecutive1s.driver();

        StringInterleaving.driver();

        NumberOfWaysToScorePoints.driver();

        LongestCommonSubsequence.driver();

        LongestCommonSubstring.driver();

        LongestIncreasingSubequence.driver();

        SumQueryIn2DImmutableArray.driver();

        MinimumJumpToReachEnd.driver();

        MaxSumIncreasingSubsequence.driver();

        MaxSumSubsequenceNonAdjacent.driver();

        LongestIncreasingSubsequence.driver();

        LongestPalindromeSubsequence.driver();

        PalindromePartitioning.driver();

        StockBuySellKtransactions.driver();

        MNPathMatrix.driver();

        DungeonGame.driver();

        DistinctSubsequences.driver();
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Regex Matcher                                           |");
        System.out.println("+---------------------------------------------------------+");
        RegexMatcher.driver();

        ActivitySelection.driver();

        FractionalKnapsack.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Job Sequence Problem                                    |");
        System.out.println("+---------------------------------------------------------+");
        JobSequenceProblem.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Minimum Number Of Platforms                             |");
        System.out.println("+---------------------------------------------------------+");
        MinimumNumberOfPlatforms.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Connect N Ropes                                         |");
        System.out.println("+---------------------------------------------------------+");
        ConnectNRopes.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Move All Zeros to end                                   |");
        System.out.println("+---------------------------------------------------------+");
        MoveAllZerosToEnd.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Minimum sorted which sorts entire array                 |");
        System.out.println("+---------------------------------------------------------+");
        MinimumSortedWhichSortsEntireArray.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Multiply All Fields Except Own Position                 |");
        System.out.println("+---------------------------------------------------------+");
        MultiplyAllFieldsExceptOwnPosition.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Nujmber of triangles in unsorted array                  |");
        System.out.println("+---------------------------------------------------------+");
        NumberOfTrianglesInUnsortedArray.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Distance between two numbers                            |");
        System.out.println("+---------------------------------------------------------+");
        DistanceBetweenTwoNumbers.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Maximum Repeating number                                |");
        System.out.println("+---------------------------------------------------------+");
        MaximumRepeatingNumber.driver();

        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| Postive and Negative number                             |");
        System.out.println("+---------------------------------------------------------+");
        PositiveAndNegativeNumberAlternatively.driver();
        
        System.out.println("\n+---------------------------------------------------------+");
        System.out.println("| CHunk Merge                                             |");
        System.out.println("+---------------------------------------------------------+");
        ChunkMerge.driver();
    }

}
