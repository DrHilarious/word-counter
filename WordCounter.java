import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sample string (or press 'Enter' to run a test): ");
        String text = scanner.nextLine();
        scanner.close();
        if (text.isEmpty()) {
            System.out.println("Input is empty. Running test instead:");
            testSortedFrequency();
        } else {
            sortedFrequency(text);
        }
    }

    public static void sortedFrequency(String text) {
        if (null == text || text.isEmpty()) {
            throw new RuntimeException("Input is empty");
        }
        Arrays.stream(text.split("^\\W+|\\b(\\s+|\\s+\\W+|\\W+\\s+|\\W+\\s+\\W+|\\s+\\W+\\s+)\\b|\\W+$"))
                .map(string -> string.toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach((entry) -> System.out.println(entry.getValue() + "\t" + entry.getKey()));
    }

    public static void testSortedFrequency() {
        sortedFrequency(
                """
                        Almost a year has passed since I came down here at your Head Master's kind invitation in order to cheer myself and cheer the hearts of a few of my friends by singing some of our own songs. The ten months that have passed have seen very terrible catastrophic events in the world — ups and downs, misfortunes — but can anyone sitting here this afternoon, this October afternoon, not feel deeply thankful for what has happened in the time that has passed and for the very great improvement in the position of our country and of our home? Why, when I was here last time we were quite alone, desperately alone, and we had been so for five or six months. We were poorly armed. We are not so poorly armed today; but then we were very poorly armed. We had the unmeasured menace of the enemy and their air attack still beating upon us, and you yourselves had had experience of this attack; and I expect you are beginning to feel impatient that there has been this long lull with nothing particular turning up!

                        But we must learn to be equally good at what is short and sharp and what is long and tough. It is generally said that the British are often better at the last. They do not expect to move from crisis to crisis; they do not always expect that each day will bring up some noble chance of war; but when they very slowly make up their minds that the thing has to be done and the job put through and finished, then, even if it takes months — if it takes years — they do it.

                        Another lesson I think we may take, just throwing our minds back to our meeting here ten months ago and now, is that appearances are often very deceptive, and as Kipling well says, we must "...meet with Triumph and Disaster. And treat those two impostors just the same."

                        You cannot tell from appearances how things will go. Sometimes imagination makes things out far worse than they are; yet without imagination not much can be done. Those people who are imaginative see many more dangers than perhaps exist; certainly many more than will happen; but then they must also pray to be given that extra courage to carry this far-reaching imagination. But for everyone, surely, what we have gone through in this period — I am addressing myself to the School — surely from this period of ten months this is the lesson: never give in, never give in, never, never, never, never — in nothing, great or small, large or petty — never give in except to convictions of honour and good sense. Never yield to force; never yield to the apparently overwhelming might of the enemy. We stood all alone a year ago, and to many countries it seemed that our account was closed, we were finished. All this tradition of ours, our songs, our School history, this part of the history of this country, were gone and finished and liquidated.

                        Very different is the mood today. Britain, other nations thought, had drawn a sponge across her slate. But instead our country stood in the gap. There was no flinching and no thought of giving in; and by what seemed almost a miracle to those outside these Islands, though we ourselves never doubted it, we now find ourselves in a position where I say that we can be sure that we have only to persevere to conquer.

                        You sang here a verse of a School Song: you sang that extra verse written in my honour, which I was very greatly complimented by and which you have repeated today. But there is one word in it I want to alter — I wanted to do so last year, but I did not venture to. It is the line: "Not less we praise in darker days."

                        I have obtained the Head Master's permission to alter darker to sterner. "Not less we praise in sterner days."

                        Do not let us speak of darker days: let us speak rather of sterner days. These are not dark days; these are great days — the greatest days our country has ever lived; and we must all thank God that we have been allowed, each of us according to our stations, to play a part in making these days memorable in the history of our race.
                        """);
    }
}
