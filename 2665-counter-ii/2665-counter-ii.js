/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let result = init;
    return {
        increment: () => {
            result = result + 1;
            return result;
        },
        decrement: () => {
            result = result - 1;
            return result;
        },
        reset: () => {
            result = init;
            return result;
        }
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */