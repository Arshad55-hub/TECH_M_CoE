import { useState } from "react";
import {
  Card,
  CardHeader,
  CardBody,
  CardFooter,
  Image,
  Text,
  Stack,
  Heading,
  Button,
  ButtonGroup,
  Divider,
  HStack,
} from "@chakra-ui/react";

function GameCard() {
  const cards = [
    {
      title: "WATCH DOGS",
      description:
        "The game is played from a third-person perspective, and its world is navigated on foot or by vehicle. Set within a fictionalized version of the Chicago metropolitan area in 2013, the single-player story follows grey hat hacker and vigilante Aiden Pearce's quest for revenge after the killing of his niece.",
      price: "$100",
      image: "https://wallpapercave.com/wp/wp2341661.jpg",
    },
    {
      title: "WATCH DOGS 2",
      description:
        "Set within a fictionalized version of the San Francisco Bay Area in 2016, Watch Dogs 2 follows the story of hacker Marcus Holloway, who is punished for a crime he did not commit through ctOS 2.0, and joins the hacking group DedSec in their efforts to raise social awareness about the dangers posed by ctOS 2.0.",
      price: "$150",
      image: "https://wallpaperset.com/w/full/a/8/8/523882.jpg",
    },
    {
      title: "WATCH DOGS LEGION",
      description:
        "It is the sequel to 2016's Watch Dogs 2 and the third installment in the Watch Dogs series. Set within a fictionalised representation of a futuristic, dystopian London, the game's story follows the hacker syndicate DedSec as they seek to clear their names after being framed for a series of terrorist bombings.",
      price: "$200",
      image:
        "https://images.hdqwalls.com/download/watch-dogs-legion-4k-2020-2c-1920x1080.jpg",
    },
    {
      title: "GOD OF WAR 4",
      description:
        "God of War, electronic action-adventure game, released by the Sony Corporation in 2005. Viewed by many as one of the all-time great titles for Sony's PlayStation 2 video-game console, God of War attracted players and impressed critics with stunning visuals, a strong story, and exciting game play.",
      price: "$250",
      image: "https://wallpaperaccess.com/full/1445287.png",
    },
    {
      title: "GOD OF WAR RAGNAROK",
      description:
        "God of War Ragnarök is an action-adventure game where players take the role of Kratos and his son as they embark on a quest to prevent the coming of Ragnarök. Players explore the Nine Realms, battling enemies in close-up, hand-to-hand combat against human-like raiders and fantastical creatures.",
      price: "$300",
      image: "https://wallpaperaccess.com/full/4021922.jpg",
    },
  ];

  const [currentPage, setCurrentPage] = useState(1);
  const cardsPerPage = 1;

  const indexOfLastCard = currentPage * cardsPerPage;
  const indexOfFirstCard = indexOfLastCard - cardsPerPage;
  const currentCards = cards.slice(indexOfFirstCard, indexOfLastCard);

  const totalPages = Math.ceil(cards.length / cardsPerPage);

  return (
    <>
      <HStack>
        {currentCards.map((card, index) => (
          <Card key={index} maxW="sm">
            <CardBody>
              <Image src={card.image} alt={card.title} borderRadius="lg" />
              <Stack mt="6" spacing="3">
                <Heading size="md">{card.title}</Heading>
                <Text>{card.description}</Text>
                <Text color="blue.600" fontSize="2xl">
                  {card.price}
                </Text>
              </Stack>
            </CardBody>
            <Divider />
            <CardFooter>
              <ButtonGroup spacing="2">
                <Button variant="solid" colorScheme="blue">
                  Buy now
                </Button>
                <Button variant="ghost" colorScheme="blue">
                  Add to cart
                </Button>
              </ButtonGroup>
            </CardFooter>
          </Card>
        ))}
      </HStack>

      <HStack mt={6} spacing={4} justify="center">
        <Button
          onClick={() => setCurrentPage((prev) => Math.max(prev - 1, 1))}
          isDisabled={currentPage === 1}
        >
          Previous
        </Button>
        <Text>
          Page {currentPage} of {totalPages}
        </Text>
        <Button
          onClick={() =>
            setCurrentPage((prev) => Math.min(prev + 1, totalPages))
          }
          isDisabled={currentPage === totalPages}
        >
          Next
        </Button>
      </HStack>
    </>
  );
}

export default GameCard;
