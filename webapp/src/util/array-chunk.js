/**
 * Splits given array to chunk arrays. Chunk size is given by second parameter
 * @param array
 * @param size
 * @returns {[]}
 */
export default function chunk(array, size) {
    const result = [];
    let index = 0;
    while (index < array.length) {
        result.push(array.slice(index, size + index));
        index += size;
    }
    return result;
}