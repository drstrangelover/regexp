package regexp

import java.util.*


internal class NFA(postfix: String) {
    var initialState: State

    init {
        var catenationState: CatenationState
        var splitState: SplitState
        var finalStates: MutableList<State>
        var fragment: Fragment
        var fragment1: Fragment
        var fragment2: Fragment
        val stack = Stack<Fragment>()
        for (c in postfix.toCharArray()) {
            when (c) {
                '?' -> {
                    fragment = stack.pop()
                    splitState = SplitState()
                    splitState.nextState1 = fragment.startState
                    finalStates = LinkedList<State>()
                    finalStates.add(splitState)
                    finalStates.addAll(fragment.finishStates)
                    stack.push(Fragment(splitState, finalStates))
                }
                '*' -> {
                    fragment = stack.pop()
                    splitState = SplitState()
                    fragment.attach(splitState)
                    splitState.nextState1 = fragment.startState
                    finalStates = LinkedList<State>()
                    finalStates.add(splitState)
                    stack.push(Fragment(splitState, finalStates))
                }
                '+' -> {
                    fragment = stack.pop()
                    splitState = SplitState()
                    fragment.attach(splitState)
                    splitState.nextState1 = fragment.startState
                    finalStates = LinkedList<State>()
                    finalStates.add(splitState)
                    stack.push(Fragment(splitState.nextState1, finalStates))
                }
                '.' -> {
                    fragment2 = stack.pop()
                    fragment1 = stack.pop()
                    stack.push(fragment1.patch(fragment2))
                }
                '|' -> {
                    fragment2 = stack.pop()
                    fragment1 = stack.pop()
                    splitState = SplitState()
                    splitState.nextState1 = fragment1.startState
                    splitState.nextState2 = fragment2.startState
                    finalStates = LinkedList<State>()
                    finalStates.addAll(fragment1.finishStates)
                    finalStates.addAll(fragment2.finishStates)
                    stack.push(Fragment(splitState, finalStates))
                }
                else -> {
                    catenationState = CatenationState(c)
                    finalStates = LinkedList<State>()
                    finalStates.add(catenationState)
                    stack.push(Fragment(catenationState, finalStates))
                }
            }
        }
        fragment = stack.pop()
        fragment.attach(AcceptableState())
        initialState = fragment.startState
    }

    fun match(string: String): Boolean {
        var currentStates: MutableList<State> = LinkedList()
        initialState.addTo(currentStates)
        for (c in string.toCharArray()) {
            val nextStates = LinkedList<State>()
            for (s in currentStates) {
                s.transaction(c, nextStates)
            }
            currentStates = nextStates
        }
        return currentStates.any { it is AcceptableState }
    }
}